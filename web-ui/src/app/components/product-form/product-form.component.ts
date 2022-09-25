import { Component, OnInit } from '@angular/core';
import { ProductResponseModel } from 'src/app/common/product-response.model';
@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  newProduct: ProductResponseModel[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  addProduct(pid: HTMLInputElement,product_name: HTMLInputElement, product_description: HTMLInputElement, product_price: HTMLInputElement, product_stock: HTMLInputElement): boolean{
    let productResponse: ProductResponseModel = new ProductResponseModel(pid.value, product_name.value, product_description.value, parseInt(product_price.value), parseInt(product_stock.value));
    this.newProduct.push(productResponse);
    console.log(this.newProduct);
    return false;
  }

}
