import {Material} from "./Material";

export class Texture {
  public id?: number;
  public texture: string | undefined;
  public materials?: Material[];
}
