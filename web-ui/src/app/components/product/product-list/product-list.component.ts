import { Component, OnInit, Input } from '@angular/core';
import { ProductResponseModel } from 'src/app/common/product-response.model';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList: ProductResponseModel[] = [];
  

  constructor(private productService:  ProductService) { }

  ngOnInit(): void {
    this.productService.getProductList().subscribe((response) => {this.formatProductReponse(response);
      console.log(response);
    } );
  }

  formatProductReponse(productResponse: Product[]): void{
    let newProductResponseModel: ProductResponseModel;
    productResponse.forEach(product => {
      newProductResponseModel = new ProductResponseModel(product.pid, product.productName, product.productDescription, product.price, product.stockPresent);
      this.productList.push(newProductResponseModel);
    })
  };

}
