// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.web;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import nl.bzk.brp.model.data.autaut.Authenticatiemiddel;
import nl.bzk.brp.model.data.autaut.Autorisatiebesluit;
import nl.bzk.brp.model.data.autaut.Bijhautorisatie;
import nl.bzk.brp.model.data.autaut.Doelbinding;
import nl.bzk.brp.model.data.autaut.HisBijhautorisatie;
import nl.bzk.brp.model.data.autaut.Uitgeslotene;
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.Doc;
import nl.bzk.brp.model.data.kern.HisDoc;
import nl.bzk.brp.model.data.kern.HisGem;
import nl.bzk.brp.model.data.kern.HisPartij;
import nl.bzk.brp.model.data.kern.HisPersadres;
import nl.bzk.brp.model.data.kern.HisPersbijhgem;
import nl.bzk.brp.model.data.kern.HisPersgeboorte;
import nl.bzk.brp.model.data.kern.HisPersoverlijden;
import nl.bzk.brp.model.data.kern.HisPerspk;
import nl.bzk.brp.model.data.kern.HisRelatie;
import nl.bzk.brp.model.data.kern.Partij;
import nl.bzk.brp.model.data.kern.Partijrol;
import nl.bzk.brp.model.data.kern.Persadres;
import nl.bzk.brp.model.data.kern.Relatie;
import nl.bzk.brp.model.data.kern.Sector;
import nl.bzk.brp.model.data.kern.Srtpartij;
import nl.bzk.brp.model.service.PersonService;
import nl.bzk.brp.model.web.PartijController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PartijController_Roo_Controller {
    
    @Autowired
    PersonService PartijController.personService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String PartijController.create(@Valid Partij partij, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, partij);
            return "partijs/create";
        }
        uiModel.asMap().clear();
        partij.persist();
        return "redirect:/partijs/" + encodeUrlPathSegment(partij.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String PartijController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Partij());
        return "partijs/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String PartijController.show(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("partij", Partij.findPartij(id));
        uiModel.addAttribute("itemId", id);
        return "partijs/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String PartijController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partijs", Partij.findPartijEntries(firstResult, sizeNo));
            float nrOfPages = (float) Partij.countPartijs() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partijs", Partij.findAllPartijs());
        }
        return "partijs/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String PartijController.update(@Valid Partij partij, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, partij);
            return "partijs/update";
        }
        uiModel.asMap().clear();
        partij.merge();
        return "redirect:/partijs/" + encodeUrlPathSegment(partij.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String PartijController.updateForm(@PathVariable("id") Integer id, Model uiModel) {
        populateEditForm(uiModel, Partij.findPartij(id));
        return "partijs/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String PartijController.delete(@PathVariable("id") Integer id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Partij partij = Partij.findPartij(id);
        partij.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/partijs";
    }
    
    void PartijController.populateEditForm(Model uiModel, Partij partij) {
        uiModel.addAttribute("partij", partij);
        uiModel.addAttribute("authenticatiemiddels", Authenticatiemiddel.findAllAuthenticatiemiddels());
        uiModel.addAttribute("autorisatiebesluits", Autorisatiebesluit.findAllAutorisatiebesluits());
        uiModel.addAttribute("bijhautorisaties", Bijhautorisatie.findAllBijhautorisaties());
        uiModel.addAttribute("doelbindings", Doelbinding.findAllDoelbindings());
        uiModel.addAttribute("hisbijhautorisaties", HisBijhautorisatie.findAllHisBijhautorisaties());
        uiModel.addAttribute("uitgeslotenes", Uitgeslotene.findAllUitgeslotenes());
        uiModel.addAttribute("acties", Actie.findAllActies());
        uiModel.addAttribute("docs", Doc.findAllDocs());
        uiModel.addAttribute("hisdocs", HisDoc.findAllHisDocs());
        uiModel.addAttribute("hisgems", HisGem.findAllHisGems());
        uiModel.addAttribute("hispartijs", HisPartij.findAllHisPartijs());
        uiModel.addAttribute("hispersadreses", HisPersadres.findAllHisPersadreses());
        uiModel.addAttribute("hispersbijhgems", HisPersbijhgem.findAllHisPersbijhgems());
        uiModel.addAttribute("hispersgeboortes", HisPersgeboorte.findAllHisPersgeboortes());
        uiModel.addAttribute("hispersoverlijdens", HisPersoverlijden.findAllHisPersoverlijdens());
        uiModel.addAttribute("hisperspks", HisPerspk.findAllHisPerspks());
        uiModel.addAttribute("hisrelaties", HisRelatie.findAllHisRelaties());
        uiModel.addAttribute("partijs", Partij.findAllPartijs());
        uiModel.addAttribute("partijrols", Partijrol.findAllPartijrols());
        uiModel.addAttribute("perses", personService.findAllPerses());
        uiModel.addAttribute("persadreses", Persadres.findAllPersadreses());
        uiModel.addAttribute("relaties", Relatie.findAllRelaties());
        uiModel.addAttribute("sectors", Sector.findAllSectors());
        uiModel.addAttribute("srtpartijs", Srtpartij.findAllSrtpartijs());
    }
    
    String PartijController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
