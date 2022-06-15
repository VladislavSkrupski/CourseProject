import {Component, Injectable, OnInit} from '@angular/core';
import {Category} from "../restClasses/Category";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})

@Injectable()
export class CreateCategoryComponent implements OnInit {
  category: Category;
  isInBase: boolean = false;

  constructor(private http: HttpClient, private router: Router) {
    this.category = new Category();
  }

  postCategory(categoryInput: Category) {
    this.isInBase = false;
    this.http.get('http://localhost:8080/categoriess/only/param/' + categoryInput.category).subscribe((res) => {
      this.category = res as Category;
      console.log(this.category);
      if (res === null) {
        console.log(categoryInput);
        this.http.post('http://localhost:8080/categories', categoryInput).subscribe((res) => {
          this.category = res as Category;
          console.log(this.category);
          this.router.navigate(['']);
        });
      } else {
        this.isInBase = true;
      }
    });
  }

  ngOnInit(): void {
  }

}
