FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SPLASH_IMAGES:sigmastudio = "file://studio.png;outsuffix=sigmastudio"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI += "\
    file://framebuf.conf \
    file://psplash-mainscreen.sh.in \
"

do_install:append:rpi() {
    install -d ${D}${systemd_system_unitdir}/psplash-start.service.d/
    install -d ${D}${libexecdir}
    install -m 0644 ${WORKDIR}/framebuf.conf ${D}${systemd_system_unitdir}/psplash-start.service.d/  
    
    sed -e 's|@@PANEL_FB_DRIVER@@|${PANEL_FB_DRIVER}|g' \
        ${WORKDIR}/psplash-mainscreen.sh.in > ${WORKDIR}/psplash-mainscreen.sh
    
    install -m 0755 ${WORKDIR}/psplash-mainscreen.sh ${D}${libexecdir}/
}

FILES:${PN} += "\
    ${systemd_system_unitdir}/psplash-start.service.d/framebuf.conf \
    ${libexecdir}/psplash-mainscreen.sh \
"