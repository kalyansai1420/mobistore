import { Component, Input,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent implements OnInit {
  isLoggedIn = false;
  products;
  cartTotal = 0;
  @Input() user;
  @Input() id;
  constructor(
    private _cartService: CartService,
    private login: LoginService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.getUserId();
    this.getProducts();
  }
  getUserId() {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe((data: any) => {
      this.isLoggedIn = this.login.isLoggedIn();
      this.user = this.login.getUser();
    });
    this.id = this.user.id;
  }

  getProducts() {
    this._cartService.getProductofCart(this.id).subscribe(
      (data: any) => {
        this.products = data;
        for (let i = 0; i < data.length; i++) {
          this.cartTotal = this.cartTotal + parseInt(data[i].product.pPrice);
        }
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  removeProductfromCart(cartId) {
    this._cartService.removeProductfromCart(cartId).subscribe(
      (data) => {
        this.products = this.products.filter(
          (product) => product.cartId != cartId
        );
        Swal.fire('Success', 'Product deleted', 'success');
        window.location.reload();
      },
      (error) => {
        Swal.fire('Error', 'Error in deleting product');
      }
    );
  }

  paymentgateway() {
    this._router.navigate(['paymentconfirmation']);
  }
}
