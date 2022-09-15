import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {


  category = {
    cTitle: '',
    cDescription: '',
  };

  constructor(private _category:CategoryService,private _snack:MatSnackBar) { }

  ngOnInit(): void {
  }

  formSubmit()
  {
    if (this.category.cTitle.trim() == '' || this.category.cTitle == null) {
      
      this._snack.open("title required", '', {
        duration:3000
      })
      return;
    }

    //all done
    this._category.addCategory(this.category).subscribe(
      (data: any) => {
        this.category.cTitle = '';
        this.category.cDescription = '';
        Swal.fire('Success', 'Category added', 'success')
        console.log(data);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error', 'Server Error', 'error');

      });


  }

}
