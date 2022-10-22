import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { CartService } from 'src/app/services/cart.service';
import Swal from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';
@Component({
  selector: 'app-load-product',
  templateUrl: './load-product.component.html',
  styleUrls: ['./load-product.component.css'],
})
export class LoadProductComponent implements OnInit {
  @Input() user;
  @Input() id;
  isLoggedIn = false;
  catId;
  products;
  p;
  productCart = {
    product: {
      pid: '',
      count:'1',
    },
    user: {
      id: '',
    },
  };
  constructor(
    private _route: ActivatedRoute,
    private _product: ProductService,
    private _cartService: CartService,
    private login: LoginService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe((data: any) => {
      this.isLoggedIn = this.login.isLoggedIn();
      this.user = this.login.getUser();
    });
    this.id = this.user.id;
    this._route.params.subscribe((params) => {
      this.catId = this._route.snapshot.params['catId'];
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

  addToCart(p) {    
    this.productCart.product.pid = p;
    this.productCart.user.id = this.id;
    this._cartService.addProducttoCart(this.productCart).subscribe(
      (data: any) => {
        Swal.fire('Success', 'Product got added', 'success');
        window.location.reload();
      },
      (error) => {
        console.log(error);
        Swal.fire('Error', 'Server Error', 'error');
      }
    );
  }
  
  
}
