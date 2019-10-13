## Summary
There is used:
- Fragments
- Android Jetpack's Navigation component 
- Singelton for game logic class
- SharedPrefences in order to storage high scores

### Structure
Tager hver krav ad gang og beskrive. 


### Loads words from dr only first time. Works if app is close and opens again. 
    public void hentOrdFraDr() throws Exception {
        if(muligeOrd.size()< 50){
