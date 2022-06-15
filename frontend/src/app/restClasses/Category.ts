import {Material} from "./Material";

export class Category {
  public id?: number;
  public category: string | undefined;
  public materials?: Material[];
}
