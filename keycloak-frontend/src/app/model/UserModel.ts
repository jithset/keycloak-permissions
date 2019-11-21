export class UserData {
    id: string;
    firstName: string;
    lastName: string;
    username: string;
    enabled: boolean;
    email: string;
    groups: string[];
    credentials: PasswordData[];
    attributes: Attributes
}


export class Attributes {
    avatar_url: string;
    mobile_number: string;
}

export class PasswordData {
    type: string;
    value: string;
    temporary: boolean;
}
