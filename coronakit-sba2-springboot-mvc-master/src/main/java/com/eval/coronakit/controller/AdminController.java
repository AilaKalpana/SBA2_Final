package com.eval.coronakit.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eval.coronakit.Exception.CkException;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/home")
	public String home() {
		return "admin-home";
	}
	
	@GetMapping("/product-entry")
	public String productEntry(Model model) {
		return "add-new-item";
	}
	
	@PostMapping("/product-save")
	public String productSave(@ModelAttribute ProductMaster product, BindingResult result,ModelMap model ) throws CkException {
		productService.saveProduct(product);
		model.addAttribute("productMasters",productService.getAllProducts());
		return "show-all-item-admin";
		
	}
	

	@GetMapping("/product-list")
	public String productList(ModelMap model) throws CkException {
		
		model.addAttribute("productMasters",  productService.getAllProducts());
		
		
		return "show-all-item-admin";
	}
	
	@RequestMapping("/product-delete/{productId}")
	public String productDelete(@PathVariable("productId") int productId, ModelMap model) throws CkException {
		productService.deleteProduct(productId);
		
		List<ProductMaster> productMasters = productService.getAllProducts();
		if( productMasters.isEmpty()) {
			model.addAttribute("productMasters",  null);
			model.addAttribute("msg",  "No Products to display");
		} else  {
			model.addAttribute("productMasters",  productMasters);
			model.addAttribute("msg",  productId + " product is deleted successfully");
		}
		//should display msg that product is deleted successfully
		
		
		return "show-all-item-admin";
	}
	
}
