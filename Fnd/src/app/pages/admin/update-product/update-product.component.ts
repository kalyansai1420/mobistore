import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css'],
})
export class UpdateProductComponent implements OnInit {
  private routeSub: Subscription;
  constructor(
    private _route: ActivatedRoute,
    private _product: ProductService,
    private _cat: CategoryService,
    private _router: Router
  ) {}

  pid = 0;
  product;
  categories;

  ngOnInit(): void {
    this.routeSub = this._route.params.subscribe((params) => {
      this.pid = params['pid'];
      // console.log(params['pid']); //log the value of id
    });
    //alert(this.pid);

    this._product.getProduct(this.pid).subscribe(
      (data: any) => {
        this.product = data;
        console.log(this.product);
      },
      (error) => {
        console.log(error);
      }
    );

    this._cat.categories().subscribe(
      (data: any) => {
        this.categories = data;
      },
      (error) => {
        alert('error in loading categories');
      }
    );
  }

  //update product
  public updateProduct() {
    this._product.updateProduct(this.product).subscribe(
      (data) => {
        Swal.fire('Success !!', 'product updated', 'success').then((e) => {
          this._router.navigate(['/admin/product']);
        });
      },
      (error) => {
        Swal.fire('Error', 'error in updating product', 'error');
        console.log(error);
      }
    );
  }

  ngOnDestroy() {
    this.routeSub.unsubscribe();
  }
}
