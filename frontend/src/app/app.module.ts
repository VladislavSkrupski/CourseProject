import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MainTableComponent} from './main-table/main-table.component';
import {HttpClientModule} from '@angular/common/http';
import {CreateFormComponent} from './create-form/create-form.component';
import {RouterModule, Routes} from "@angular/router";
import {CreateBrandComponent} from './create-brand/create-brand.component';
import {CreateMaterialComponent} from './create-material/create-material.component';
import {CreateCategoryComponent} from './create-category/create-category.component';
import {CreateDecorComponent} from './create-decor/create-decor.component';
import {CreateTextureComponent} from './create-texture/create-texture.component';
import {CreateThicknessComponent} from './create-thickness/create-thickness.component';
import {CreateFormatComponent} from './create-format/create-format.component';
import {FormsModule} from "@angular/forms";
import {MatTableModule} from "@angular/material/table";

const createPages: Routes = [
  {path: 'create-form', component: CreateFormComponent},
  {path: 'create-brand', component: CreateBrandComponent},
  {path: 'create-category', component: CreateCategoryComponent},
  {path: 'create-decor', component: CreateDecorComponent},
  {path: 'create-format', component: CreateFormatComponent},
  {path: 'create-texture', component: CreateTextureComponent},
  {path: 'create-thickness', component: CreateThicknessComponent},
  {path: 'create-material', component: CreateMaterialComponent},
  {path: '', component: MainTableComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    MainTableComponent,
    CreateFormComponent,
    CreateBrandComponent,
    CreateMaterialComponent,
    CreateCategoryComponent,
    CreateDecorComponent,
    CreateTextureComponent,
    CreateThicknessComponent,
    CreateFormatComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    HttpClientModule,
    RouterModule.forRoot(createPages),
    FormsModule,
    MatTableModule,
  ],
  providers: [CreateBrandComponent],
  bootstrap: [AppComponent]

})
export class AppModule {

}
