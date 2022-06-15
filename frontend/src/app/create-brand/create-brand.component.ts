import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Brand} from "../restClasses/Brand";
import {Router} from "@angular/router";

@Component({
  selector: 'create-brand',
  templateUrl: './create-brand.component.html',
  styleUrls: ['./create-brand.component.css']
})

@Injectable()
export class CreateBrandComponent implements OnInit {
  brand: Brand;
  isInBase: boolean = false;

  constructor(private http: HttpClient, private router: Router) {
    this.brand = new Brand();
  }

  postBrand(brandInput: Brand) {
    this.isInBase = false;
    this.http.get('http://localhost:8080/brands/only/param/' + brandInput.brand).subscribe((res) => {
      this.brand = res as Brand;
      console.log(this.brand);
      if (res === null) {
        console.log(brandInput);
        this.http.post('http://localhost:8080/brands', brandInput).subscribe((res) => {
          this.brand = res as Brand;
          console.log(this.brand);
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


