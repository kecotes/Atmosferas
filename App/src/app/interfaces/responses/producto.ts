export interface ProductoListarTodosResponse {
    id: number;
    name: string;
    description: string;
    price: string;
    image: string;
    created_at: string;
    updated_at: string;
}

export interface ProductoVerResponse {
    name: string;
    description: string;
    price: string;
    image: string;
    created_at: string;
    updated_at: string;
}