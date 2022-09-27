export class ProductPostModel {
    constructor(
        public pid: string, 
        public productName: string, 
        public productDescription: string, 
        public price: number, 
        public stockPresent: number){}
}