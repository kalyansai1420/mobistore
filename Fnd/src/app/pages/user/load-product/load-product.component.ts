import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { CartService } from 'src/app/services/cart.service';
@Component({
  selector: 'app-load-product',
  templateUrl: './load-product.component.html',
  styleUrls: ['./load-product.component.css'],
})
export class LoadProductComponent implements OnInit {
  catId;
  products;
  constructor(
    private _route: ActivatedRoute,
    private _product: ProductService,
    private _cartService: CartService
  ) {}
  addToCart(product: LoadProductComponent) {
    this._cartService.addToCart(product);
    //window.alert('Your product has been added to the cart!');
  }

  ngOnInit(): void {
    this._route.params.subscribe((params) => {
      this.catId = this._route.snapshot.params['catId'];
      //this.catId = params['catId'];
      if (this.catId == 0) {
        this._product.products().subscribe(
          (data: any) => {
            this.products = data;
            console.log(data);
          },
          (error) => {
            console.log(error);
          }
        );
        console.log('Load all products');
      } else {
        console.log('Load specific products');
        this._product.getProductOfCategory(this.catId).subscribe(
          (data: any) => {
            this.products = data;
            console.log(data);
          },
          (error: any) => {
            console.log(error);
          }
        );
      }
    });
  }
}
