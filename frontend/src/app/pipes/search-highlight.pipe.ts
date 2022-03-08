import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchHighlight'
})
export class SearchHighlightPipe implements PipeTransform {

  transform(value: string, args: string):any {
    if (!args){
      return value; }
    var re = new RegExp(args, 'gi');
    value = value.replace(re, `<span class='highlight-search-text'>${args}</span>`);
    return value;
  }
}

