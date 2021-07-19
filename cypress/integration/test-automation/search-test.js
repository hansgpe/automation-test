describe('search in catalogo',(cards)=>{
it('search in catalog',()=>{
cy.visit('localhost:3000/shows')
cy.get('input').type('Batman')
cy.get('.btn').click();

cy.get('.card').each(($item,index)=>{
    if(index==1){
        cy.get($item).scrollIntoView();
        return false;
    }
});
cy.go('back');


})
})