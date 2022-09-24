import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api/products";

  constructor(private httpClient: HttpClient) { }

  getProductList() {
    return this.httpClient.get<Product[]>(this.baseUrl);
  }
}
