import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {
    const modal = document.querySelector('.modal')!;
    const overlay = document.querySelector('.overlay')!;
    const btnCloseModal = document.querySelector('.close-modal')!;
    const btnOpenModal = document.querySelector('.form')!;

    function OpenModal() {
      overlay.classList.remove('hidden');
      modal.classList.remove('hidden');
      overlay.classList.add('over-view');
      modal.classList.add('modal-view');
    }
    function CloseModal() {
      overlay.classList.remove('over-view');
      modal.classList.remove('modal-view');
      overlay.classList.add('over-hide');
      modal.classList.add('modal-hide');
      setTimeout(() => {
        overlay.classList.remove('over-hide');
        modal.classList.remove('modal-hide');
        overlay.classList.add('hidden');
        modal.classList.add('hidden');
      }, 200);
    }

    btnOpenModal.addEventListener('click', OpenModal);
    btnCloseModal.addEventListener('click', CloseModal);
    overlay.addEventListener('click', CloseModal);
    document.addEventListener('keydown', function (event) {
      if (event.code === 'Escape' && !modal.classList.contains('hidden')) {
        CloseModal();
      }
    });
  }
}
