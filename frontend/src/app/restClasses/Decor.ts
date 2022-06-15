import {Material} from "./Material";

export class Decor {
  public id?: number;
  public decorArticle: string | undefined;
  public decorName: string | undefined;
  public materials?: Material[];
}
