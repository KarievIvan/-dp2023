import { Component, Input, OnInit } from '@angular/core';
import { Shampoo } from 'src/app/interfaces/shampoo';
import { ShampooService } from 'src/app/services/shampoo.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  @Input() currentShampoo!: Shampoo;
  newShampoo: Shampoo = new Shampoo();

  constructor(private service: ShampooService) {}

  ngOnInit(): void {
    this.service.getShampoo().subscribe((data) => {
      this.currentShampoo = data[0];
    });
  }

  onEdit() {
    this.service.updateShampoo(this.currentShampoo).subscribe(() => {
      this.updateShampoo();
    });
  }

  updateShampoo() {
    this.service.getShampoo().subscribe((devices) => {
      this.service.setList(devices);
    });
  }

  onAdd() {
    this.newShampoo.id = -1;
    console.log(this.newShampoo);
    this.service.createShampoo(this.newShampoo).subscribe((data) => {
      this.updateShampoo();
      window.location.reload();
    });
  }
}
