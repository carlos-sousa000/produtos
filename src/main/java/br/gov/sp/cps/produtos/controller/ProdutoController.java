package br.gov.sp.cps.produtos.controller;

import br.gov.sp.cps.produtos.entity.Produto;
import br.gov.sp.cps.produtos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", produtoService.listarProdutos());
        model.addAttribute("totalProdutos", produtoService.contarProdutos());
        model.addAttribute("produto", new Produto());
        return "produtos";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produtos", produtoService.listarProdutos());
        model.addAttribute("totalProdutos", produtoService.contarProdutos());
        model.addAttribute("produto", new Produto());
        return "produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id).orElse(null);

        if (produto == null) {
            return "redirect:/produtos";
        }

        model.addAttribute("produtos", produtoService.listarProdutos());
        model.addAttribute("totalProdutos", produtoService.contarProdutos());
        model.addAttribute("produto", produto);
        return "produtos";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("produto") Produto produto,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("produtos", produtoService.listarProdutos());
            model.addAttribute("totalProdutos", produtoService.contarProdutos());
            return "produtos";
        }

        produtoService.salvarProduto(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
        return "redirect:/produtos";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        produtoService.excluirProduto(id);
        redirectAttributes.addFlashAttribute("mensagem", "Produto excluído com sucesso!");
        return "redirect:/produtos";
    }
}
