import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css'],
})
export class AddProductComponent implements OnInit {
  categories = [
    {
      cid: '',
      cTitle: '',
    }
  ];

  productData = {
    pName: '',
    pDescription: '',
    pPrice: '',
    pPhoto: '',
    category: {
      cid: '',
    },
  };

  constructor(
    private _cat: CategoryService,
    private _snack: MatSnackBar,
    private _product:ProductService,
  ) { }

  ngOnInit(): void {
    this._cat.categories().subscribe(
      (data: any) => {
        this.categories = data;
        console.log(this.categories);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  addProduct() {
    if (
      this.productData.pName.trim() == '' ||
      this.productData.pName == null
    ) {
      this._snack.open('Name Required !!', '', {
        duration: 3000,
      });
      return;
    }
    //validation...

    //call server
    this._product.addProduct(this.productData).subscribe(
      (data:any) => {

        Swal.fire('Success', 'product is added', 'success');
        this.productData = {
          pName: '',
          pDescription: '',
          pPrice: '',
          pPhoto: '',
          category: {
            cid: '',
          },
        };
        console.log(data)
      },

      (error) => {
        Swal.fire('Error!! ', 'Error while adding product', 'error');
        console.log(error);
      }
    );
  }
}
