import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  addProduct(product_name: HTMLInputElement, product_description: HTMLInputElement, product_price: HTMLInputElement, product_stock: HTMLInputElement): boolean{
    console.log(`
      called add product
      ${product_name.value} ${product_description.value} ${product_price.value} ${product_stock.value}
    `);
    return false;
  }

}
