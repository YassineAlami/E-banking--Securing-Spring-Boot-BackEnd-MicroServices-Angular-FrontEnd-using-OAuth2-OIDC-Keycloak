import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products : any;
  constructor(private http:HttpClient) {
  }

  ngOnInit(): void {
    this.getProducts();
  }

  public getProducts(){
    this.http.get("http://localhost:8098/products").subscribe({
      next:data=>{
        this.products=data;
      },
      error:err => console.log(err)
    })
  }



}
