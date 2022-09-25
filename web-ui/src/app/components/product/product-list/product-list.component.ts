import { Component, OnInit, Input } from '@angular/core';
import { ProductResponseModel } from 'src/app/common/product-response.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  @Input() productList: ProductResponseModel[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
