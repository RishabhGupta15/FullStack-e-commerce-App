import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product.model';
import { ProductResponseModel } from '../common/product-response.model';
import { ProductPostModel } from '../common/product-post.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api/products";

  constructor(private httpClient: HttpClient) { }

  getProductList() {
    return this.httpClient.get<Product[]>(this.baseUrl);
  }

  saveProduct(newProduct: ProductPostModel) {
    return this.httpClient.post(`${this.baseUrl}/add`, newProduct);
  }
}
