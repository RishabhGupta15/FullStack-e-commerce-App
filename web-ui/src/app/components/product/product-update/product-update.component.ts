import { Component, OnInit } from '@angular/core';
import { ProductResponseModel } from 'src/app/common/product-response.model';
import { ProductService } from 'src/app/services/product.service';
import { ProductPostModel } from 'src/app/common/product-post.model';
import { Router } from '@angular/router'

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  constructor(private productService: ProductService, private router: Router) { 
  }

  ngOnInit(): void {
  }

  updateProduct(pid: HTMLInputElement,product_name: HTMLInputElement, product_description: HTMLInputElement, product_price: HTMLInputElement, product_stock: HTMLInputElement): boolean{
    let productResponse: ProductPostModel = new ProductPostModel(pid.value, product_name.value, product_description.value, parseFloat(product_price.value), parseInt(product_stock.value));
    this.productService.updateProduct(productResponse).subscribe(
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
