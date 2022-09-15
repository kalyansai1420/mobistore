import { Injectable } from '@angular/core';
import { LoadProductComponent } from '../pages/user/load-product/load-product.component';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  items: LoadProductComponent[] = [];

  constructor() {}

  addToCart(product: LoadProductComponent) {
    this.items.push(product);
  }

  getItems() {
    return this.items;
  }

  clearCart() {
    this.items = [];
    return this.items;
  }
}
