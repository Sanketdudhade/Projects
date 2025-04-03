let gameseq=[];
let userseq=[];
let started=false;
let levelup=0;
let preScore=0;

let h2=document.querySelector("h2");
let btn=["red","yellow","green","blue"];

document.addEventListener("keypress",function(){
    if(started==false){
        console.log("game started");
        started=true;
        levelUp();
    }
});
function btnFlash(btn){
    btn.classList.add("flash");
    setTimeout(function(){
        btn.classList.remove("flash");
    },250);

};
function levelUp(){
    userseq=[];
    levelup++;
    h2.innerText=`Level ${levelup}`;
    let randidx=Math.floor(Math.random()*3);
    let randcolor=btn[randidx];
    let randbtn=document.querySelector(`.${randcolor}`);
    // console.log(randidx);
    // console.log(randcolor);
    // console.log(randbtn);
    gameseq.push(randcolor);
    console.log(gameseq);
    btnFlash(randbtn);

}
function checked(index){
    
    if(userseq[index]==gameseq[index]){
        if(userseq.length === gameseq.length){
            setTimeout(levelUp,1000);
        }
    }else{
        h2.innerHTML=`Game over! Your score is <b>${levelup}</b>  <br>press any key to start game
        <br> Highscore Till  now ${high()}`;
        document.querySelector("body").style.backgroundColor="red";
        setTimeout(function(){
            document.querySelector("body").style.backgroundColor="white";
        },150);
        reset();
    }

}

function btnpress(){
    // console.log(this);
    btnFlash(this);
    let usercolor=this.getAttribute("id");
    // console.log(usercolor);
    userseq.push(usercolor);
    checked(userseq.length-1);

}
let allBtns=document.querySelectorAll(".btn");
for(btns of allBtns){
    btns.addEventListener("click",btnpress);
}

function reset(){
    started=false;
    gameseq=[];
    userseq=[];
    preScore=levelup;
    levelup=0;

}
function high(){
    
    let highscore;
    let curScore=levelup;
    if (preScore <=curScore){
        highscore=curScore;
        
    }
    else{
        highscore=preScore;
        
    }
    return highscore;


}