document.addEventListener('DOMContentLoaded', () => {
    window.scrollTo({top: 0, behavior: 'smooth'});
    const msg = document.getElementsByClassName("message")[0];
    if(msg){
        setTimeout(() => {
            msg.classList.add("hide-message");
        }, 900);
    }
})
const addForm = document.getElementById('addForm');
const updateForm = document.getElementById('updateForm');
const updateButtons = document.querySelectorAll('.update-btn');

const showUpdateForm = (demandeDescription, demandeId) => {
    document.getElementById('UpdateDescriptionId').value = demandeDescription;
    document.getElementById('hiddenDemandeIdInput').value = demandeId;
    if(!addForm.classList.contains('hidden')) {
        addForm.style.opacity = '0';
        setTimeout(() => {
            addForm.classList.add('hidden');
            updateForm.classList.remove('hidden');
            updateForm.style.position = 'relative';
            // Fade in the update form
            updateForm.style.opacity = '1';
            addForm.style.position = 'absolute';
            window.scrollTo({top: 0, behavior: 'smooth'});
        }, 600);
    }else{
        window.scrollTo({top: 0, behavior: 'smooth'});
    }
};
const hideUpdateForm = () => {
    // Fade out the update form
    updateForm.style.opacity = '0';
    setTimeout(() => {
        updateForm.classList.add('hidden');
        addForm.classList.remove('hidden');
        // Fade in the add form
        addForm.style.opacity = '1';
        addForm.style.position = 'relative';
        updateForm.style.position = 'absolute';
        window.scrollTo({top: 0, behavior: 'smooth'});
    }, 600);
};
const deleteDemande = (demandeId) => {
    if(confirm('Voulez-vous vraiment supprimer cette demande ?')){
        window.location.href = `/demandeDelete/${demandeId}`;
    }
}
