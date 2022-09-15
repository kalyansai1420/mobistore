import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _http: HttpClient) { }
  

  //load all the products
  public products()
  {
    return this._http.get(`${baseUrl}/product/`);
  }

  //add new product
  public addProduct(product) {
    return this._http.post(`${baseUrl}/product/`, product);
  }

  //delete product
  public deleteProduct(pid) {
    return this._http.delete(`${baseUrl}/product/${pid}`)
  }

  //get product
  public getProduct(pid) {
    return this._http.get(`${baseUrl}/product/${pid}`);
  }

  //update product
  public updateProduct(product) {
    return this._http.put(`${baseUrl}/product/`, product);
  }

  //get product
  public getProductOfCategory(cid) {
    return this._http.get(`${baseUrl}/product/category/${cid}`)
  }
}
