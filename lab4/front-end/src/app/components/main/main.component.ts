import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Shampoo } from 'src/app/interfaces/shampoo';
import { ShampooService } from 'src/app/services/shampoo.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
})
export class MainComponent implements OnInit {
  shampooList!: Shampoo[];
  currentShampoo: Shampoo = new Shampoo();
  page: number = 1;
  show = false;

  constructor(private service: ShampooService) {}

  ngOnInit(): void {
    this.service.getShampoo().subscribe((data) => {
      this.shampooList = data;
    });
  }

  @Output() OnEditShampoo = new EventEmitter<Shampoo>();

  choseShampoo(shampoo: Shampoo) {
    this.OnEditShampoo.emit(shampoo);
  }

  onDelete(shampoo: Shampoo) {
    this.service.deleteShampoo(shampoo).subscribe(() => {
      this.updateShampoo();
      window.location.reload();
    });
  }

  updateShampoo() {
    this.service.getShampoo().subscribe((shampoo) => {
      this.service.setList(shampoo);
    });
  }
}
