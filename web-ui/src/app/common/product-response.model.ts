export class ProductResponseModel {
    constructor(
        public pid: string, 
        public productName: string, 
        public productDescription: string, 
        public productPrice: number, 
        public stock: number){}
}