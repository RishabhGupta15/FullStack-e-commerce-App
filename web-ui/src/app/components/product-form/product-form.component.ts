import { Component, OnInit } from '@angular/core';
import { ProductResponseModel } from 'src/app/common/product-response.model';
import { ProductService } from 'src/app/services/product.service';
import { ProductPostModel } from 'src/app/common/product-post.model';
import { Router } from '@angular/router'
@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  newProduct: ProductPostModel[] = [];

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
  }

  addProduct(pid: HTMLInputElement,product_name: HTMLInputElement, product_description: HTMLInputElement, product_price: HTMLInputElement, product_stock: HTMLInputElement): boolean{
    let productResponse: ProductPostModel = new ProductPostModel(pid.value, product_name.value, product_description.value, parseFloat(product_price.value), parseFloat(product_stock.value));
    this.newProduct.push(productResponse);
    console.log(this.newProduct);
    this.productService.saveProduct(productResponse).subscribe(
      data => {
        console.log("------");
        console.log(data);
      }
    );
    this.loadProductList();
    return true;
  }

  loadProductList(){
    this.router.navigate(["/products"]);
  }

}
