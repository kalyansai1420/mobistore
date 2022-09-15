import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css'],
})
export class ViewProductsComponent implements OnInit {
  products = [
    {
      pid: '',
      pDescription: '',
      pName: '',
      pPhoto: '',
      pPrice: '',
      category: {
        cid: '',
      },
    },
  ];

  constructor(private _product: ProductService) {}

  ngOnInit(): void {
    this._product.products().subscribe(
      (data: any) => {
        this.products = data;
        console.log(this.products);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  deleteProduct(pid) {
    Swal.fire({
      icon: 'info',
      title: 'Are you sure ?',
      confirmButtonText: 'Delete',
      showCancelButton: true,
    }).then((result) => {
      if (result.isConfirmed) {
        this._product.deleteProduct(pid).subscribe(
          (data) => {
            this.products = this.products.filter(
              (product) => product.pid != pid
            );
            Swal.fire('Success', 'Product deleted', 'success');
          },
          (error) => {
            Swal.fire('Error', 'Error in deleting product');
          }
        );
      }
    });
  }
  // updateProduct(pid) {
  //   //alert(pid);
  // }
}
