import { Component, OnInit, Input } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() productName: string="";
  @Input() productDescription: string="";
  @Input() pid: string="";
  @Input() price: number=0;
  @Input() stock: number=0;
 
  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
  }

  deleteProduct(){
    this.productService.deleteProduct(this.pid).subscribe(
      data => {console.log(data)}
    );
    this.loadProductList();
  };

  loadProductList(){
    location.reload();
  }

}
