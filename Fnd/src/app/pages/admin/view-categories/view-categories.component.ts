import { Component, OnInit } from '@angular/core';
import { Subscriber } from 'rxjs';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-view-categories',
  templateUrl: './view-categories.component.html',
  styleUrls: ['./view-categories.component.css']
})
export class ViewCategoriesComponent implements OnInit {

  categories = [
    {
      cTitle: '',
      cDescription:''
    }
  ]

  constructor( private _category:CategoryService) { }

  ngOnInit(): void {

    this._category.categories().subscribe((data: any) => {
      this.categories = data;
      console.log(this.categories);
    },
      (error) => {
        console.log(error);

      }
    )
  }

}
