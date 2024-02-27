export interface VerUsuarioResponse {
    name: string;
    lastname: string;
    email: string;
    password: string;
    type_document: string;
    document: string;
    pais: string;
    department: string;
    city: string;
    address: string;
    rol: VerUsuarioRol;
}

export interface VerUsuarioRol {
    id: number;
}