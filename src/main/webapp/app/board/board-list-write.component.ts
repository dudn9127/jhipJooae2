import { Component, OnInit } from '@angular/core';
import { Board } from 'app/core/board/board.model';
import { BoardService } from 'app/core/board/board.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'jhi-board-list-write',
  templateUrl: './board-list-write.component.html'
})
export class BoardListWriteComponent implements OnInit {
  board: Board;
  isSaving: boolean;

  newForm = this.fb.group({
    id: [null],
    title: ['', [Validators.required, Validators.maxLength(50)]],
    content: ['', Validators.maxLength(1000)],
    imgUrl: ['', Validators.maxLength(256)],
    createdTime: ['default'],
    modifiedDate: [null]
  });

  constructor(private boardService: BoardService, private route: ActivatedRoute, private router: Router, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.isSaving = false;

    this.updateForm(this.board);
  }

  private updateForm(board: Board): void {
    this.newForm.patchValue({
      id: board.id,
      title: board.title,
      content: board.content,
      imgUrl: board.imgUrl,
      createdTime: board.createdTime
      // modifiedDate:board.modifiedDate
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    alert('first');
    this.updateBoard(this.board);
    alert('second');
    this.boardService.create(this.board).subscribe(response => this.onSaveSuccess(response), () => this.onSaveError());
  }

  private updateBoard(board: Board): void {
    alert('update1');
    board.title = this.newForm.get(['tt']).value;
    alert('update2');
    board.content = this.newForm.get(['content']).value;
    board.imgUrl = this.newForm.get(['imgUrl']).value;
    alert('update3');
    //board.modifiedDate=this.newForm.get(['modifiedDate']).value;
  }

  private onSaveSuccess(result) {
    alert('success');
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    alert('fail');
    this.isSaving = false;
  }
}
