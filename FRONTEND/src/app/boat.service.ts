import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Boat } from "./boat";
import { environment } from "../environments/environment";


@Injectable({providedIn: 'root'})
export class BoatService {

    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    public login(username: string, password: string): Observable<any> {
        console.log(`Logging in with username: ${username}`);
        console.log(`Logging in with password: ${password}`);
        const credentials = { username: username, password: password };
        return this.http.post(`${this.apiServerUrl}/login`, credentials, { responseType: 'text' });
      }
      
    public getBoats(): Observable<Boat[]> {
        return this.http.get<Boat[]>(`${this.apiServerUrl}/`);
    }

    public getBoatById(boatId: number): Observable<void> {
        return this.http.get<void>(`${this.apiServerUrl}/getBoat/${boatId}`);
    }

    public addBoat(boat: Boat): Observable<Boat> {
        return this.http.post<Boat>(`${this.apiServerUrl}/addBoat`, boat);
    }

    public updateBoat(boat: Boat): Observable<Boat> {
        return this.http.put<Boat>(`${this.apiServerUrl}/updBoat`, boat);
    }

    public deleteBoatById(boatId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/deleteBoat/${boatId}`);
    }

    public deleteBoats(boatIds: number[]): Observable<void> {
        const params = new HttpParams().set('ids', boatIds.join(','));
        return this.http.delete<void>(`${this.apiServerUrl}/deleteBoats`, { params });
      }
      
}
