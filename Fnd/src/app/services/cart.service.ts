import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { LoadProductComponent } from '../pages/user/load-product/load-product.component';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class CartService {

  constructor(
    private _http:HttpClient
  ) {}

  
  //add product to cart
  public addProducttoCart(productCart) {
    return this._http.post(`${baseUrl}/cart/`, productCart);
  }

  //remove product from cart
  public removeProductfromCart(cartId) {
    return this._http.delete(`${baseUrl}/cart/${cartId}`)
  }


  //get product from cart
  public getProductofCart(id) {
    return this._http.get(`${baseUrl}/cart/user/${id}`)
  }

  //update product
  public updateProduct(productCart) {
    return this._http.put(`${baseUrl}/cart/`, productCart);
  }

  //empty cart
  public emptyCart(id) {
    return this._http.get(`${baseUrl}/cart/user/${id}`);
  }
}
