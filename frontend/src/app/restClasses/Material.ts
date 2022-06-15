import {Brand} from "./Brand";
import {Category} from "./Category";
import {Format} from "./Format";
import {Thickness} from "./Thickness";
import {Decor} from "./Decor";
import {Texture} from "./Texture";

export class Material {
  public id?: number;
  public brand: Brand | undefined;
  public category: Category | undefined;
  public format: Format | undefined;
  public thickness: Thickness | undefined;
  public decor: Decor | undefined;
  public texture: Texture | undefined;
  public measureUnit: string | undefined;
  public cost: number | undefined;
  public pictureAddress: string | undefined;
}
