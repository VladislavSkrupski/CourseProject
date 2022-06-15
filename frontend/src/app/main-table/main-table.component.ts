import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Material} from "../restClasses/Material";
import {Brand} from "../restClasses/Brand";
import {Category} from "../restClasses/Category";
import {Format} from "../restClasses/Format";
import {Thickness} from "../restClasses/Thickness";

@Component({
  selector: 'main-table',
  templateUrl: './main-table.component.html',
  styleUrls: ['./main-table.component.css']
})
export class MainTableComponent implements OnInit {
  brands: Brand[] = [];
  categories: Category[] = [];
  formats: Format[] = [];
  thicknesses: Thickness[] = [];
  materials: Material[] = [];


  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.getBrands();
    this.getCategories();
    this.getFormats();
    this.getThicknesses();
    this.getMaterials();
  }

  getBrands() {
    const url = 'http://localhost:8080/brands/only';
    this.http.get(url).subscribe((res) => {
      this.brands = <Brand[]>res;
      console.log(this.brands);
    })
  }

  getCategories() {
    const url = 'http://localhost:8080/categories/only';
    this.http.get(url).subscribe((res) => {
      this.categories = <Category[]>res;
      console.log(this.categories);
    })
  }

  getFormats() {
    const url = 'http://localhost:8080/formats/only';
    this.http.get(url).subscribe((res) => {
      this.formats = <Format[]>res;
      console.log(this.formats);
    })
  }

  getThicknesses() {
    const url = 'http://localhost:8080/thicknesses/only';
    this.http.get(url).subscribe((res) => {
      this.thicknesses = <Thickness[]>res;
      console.log(this.thicknesses);
    })
  }

  getMaterials() {
    const url = 'http://localhost:8080/materials/';
    this.http.get(url).subscribe((res) => {
      this.materials = <Material[]>res;
      console.log(this.materials);
    })
  }


}


