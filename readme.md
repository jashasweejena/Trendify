# Trendify

First of all, a few screenshots:

Repository Details!          
:-------------------------:|
![Repository Details](https://github.com/jashasweejena/Trendify/raw/master/screenshots/repo_details_1.png)  

Repository List          |  Developers List
:-------------------------:|:-------------------------: 
![Repository List](https://github.com/jashasweejena/Trendify/raw/master/screenshots/repo_ss.png)  |  ![Developers List](https://github.com/jashasweejena/Trendify/raw/master/screenshots/dev_ss.png) 


## What is this?

Trendify : An app that lists trending Github Repos and Developers. It is based on MVVM Architecture.


## Dependencies

- Android Lifecycle components 
- Glide for image loading
- Recyclerview for view rendering
- Retrofit and GSON for JSON parsing
- CircleImageView to show avatar

## Supported devices

The app supports every device with a SDK level of at least 21 (Android Android 5.0 Lollipop+).


## Quick walkthrough

The app is divided into 6 Units
- adapters 
- fragments
- models
- repositories
- viewmodels
- views

### Adapters

- DevRecyclerViewAdapter : Handles the RecyclerView adapter for Developers list
- RepoRecyclerViewAdapter: Handles the same for Repositories list

### Fragments

- DevelopersFragment : Acts as View for the Developers list
- RepoFragment: Handles the same for Repositories list

### Models

- Developers : POJO that is used in Retrofit as well as RecyclerView for Developers List
- Repositories: POJO that is used in Retrofit as well as Recyclerview for Repositories List

### Repositores

- DevRepository: Android lifecycle component which fetches data from the API for Developers List
- RepoRepository: Does the same thing for Repositories List
- RestClient: Initializes and provdies instance for Retrofit
- RestService: Defines endpoints of the API URL

### Viewmodels

- DevViewModel: Acts as a bridge between View (Activity) and Repository for Developers List
- RepoViewModel: Does the same thing for Repositories list

### Views

- MainActivity: Initializes both the fragments and helps switch between them
- RepoDetailsActivity: On clicking a Repository item, this activity opens up showing details of the repo







 
