import {Component, OnInit, ViewChild, ComponentFactoryResolver, OnDestroy} from '@angular/core';
import { AdDirective } from './ad.directive';

@Component({
    selector: 'app-ad-banner',
    template: `
      <div>
        <ng-template adHost></ng-template>
      </div>
    `
})

export class AdBannerComponent implements OnInit, OnDestroy {
    currentAdIndex = -1;
    @ViewChild(AdDirective, { static: true }) adHost: AdDirective;
    interval: any;

    constructor(private componentFactoryResolver: ComponentFactoryResolver) { }

    ngOnInit() {
        this.loadComponent();
        this.getAds();
    }

    ngOnDestroy() {
        clearInterval(this.interval);
    }

    async loadComponent() {
        const { HeroJobAdComponent } = await import('./hero-job-ad.component');
        const { HeroProfileComponent } = await import('./hero-profile.component');

        let component: any = [HeroJobAdComponent, HeroProfileComponent]

        this.currentAdIndex = (this.currentAdIndex + 1) % component.length;
        const adItem = component[this.currentAdIndex];

        const viewContainerRef = this.adHost.viewContainerRef;
        viewContainerRef.clear();

       return viewContainerRef.createComponent(
            this.componentFactoryResolver.resolveComponentFactory(adItem)
        );
    }

    getAds() {
        setInterval(() => {
            this.loadComponent();
        }, 3000);
    }
}