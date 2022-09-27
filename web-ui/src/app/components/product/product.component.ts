import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() productName: string="";
  @Input() productDescription: string="";
  // @Input() pid: string="";
  @Input() price: number=0;
  @Input() stock: number=0;
 
  constructor() { }

  ngOnInit(): void {
  }

}
