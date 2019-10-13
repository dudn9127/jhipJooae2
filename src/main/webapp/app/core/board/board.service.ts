import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IBoard } from './board.model';
import { IUser } from 'app/core/user/user.model';

@Injectable({ providedIn: 'root' })
export class BoardService {
  public resourceUrl = SERVER_API_URL + 'api/board';

  constructor(private http: HttpClient) {}

  create(board: IBoard): Observable<HttpResponse<IBoard>> {
    return this.http.post<IBoard>(this.resourceUrl, board, { observe: 'response' });
  }

  find(id: any): Observable<HttpResponse<IBoard>> {
    return this.http.get<IBoard>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
  delete(id: any): Observable<HttpResponse<any>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<HttpResponse<IBoard[]>> {
    const options = createRequestOption(req);
    return this.http.get<IBoard[]>(this.resourceUrl, { params: options, observe: 'response' });
  }
}
