export interface IBoard {
  id?: any;
  title?: string;
  content?: string;
  imgUrl?: string;
  createdTime?: Date;
  modifiedDate?: Date;
}

export class Board implements Board {
  constructor(
    public id?: any,
    public title?: string,
    public content?: string,
    public imgUrl?: string,
    public createdTime?: Date,
    public modifiedDate?: Date
  ) {
    this.id = id ? id : null;
    this.title = title ? title : null;
    this.content = content ? content : null;
    this.imgUrl = imgUrl ? imgUrl : null;
    this.createdTime = createdTime ? createdTime : null;
    this.modifiedDate = modifiedDate ? modifiedDate : null;
  }
}
